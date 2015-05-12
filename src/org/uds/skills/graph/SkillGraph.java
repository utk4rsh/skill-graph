package org.uds.skills.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SkillGraph {

	private final int V;
	private long E;
	private Map<Skill, List<Skill>> adj;

	public SkillGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = new HashMap<Skill, List<Skill>>();
	}

	public SkillGraph(int V, int E) {
		this(V);
		if (E < 0)
			throw new IllegalArgumentException("Number of edges must be nonnegative");
		for (int i = 0; i < E; i++) {
			int v = (int) (Math.random() * V);
			int w = (int) (Math.random() * V);
			Skill childskill = new Skill(Integer.toString(v));
			Skill parentskill = new Skill(Integer.toString(w));
			addEdge(new DirectedSkillEdge(parentskill, childskill));
		}
	}

	public SkillGraph(SkillGraph G) {
		this(G.V());
		this.E = G.E();
		for (Skill skill : adj.keySet()) {
			// reverse so that adjacency list is in same order as original
			Stack<Skill> reverse = new Stack<Skill>();
			for (Skill e : G.adj.get(skill.getVertexId())) {
				reverse.push(e);
			}
			List<Skill> skillEdges = new ArrayList<Skill>();
			for (Skill e : reverse) {
				skillEdges.add(e);
			}
			adj.put(skill, skillEdges);
		}
	}

	public int V() {
		return V;
	}

	public long E() {
		return E;
	}

	public void addEdge(DirectedSkillEdge e) {
		Skill parent = e.getParentSkillNode();
		Skill child = e.getChildSkillNode();
		if (adj.get(parent) == null) {
			List<Skill> edgesOfV = new ArrayList<Skill>();
			edgesOfV.add(child);
			adj.put(parent, edgesOfV);
		} else {
			adj.get(parent).add(child);
		}
		E++;
	}

	public Iterable<Skill> adj(Skill v) {
		if (adj.get(v) == null)
			return Collections.emptyList();
		return adj.get(v);
	}

	public int degree(String v) {
		return adj.get(v).size();
	}

	public Iterable<Skill> edges() {
		List<Skill> list = new ArrayList<Skill>();
		for (Skill skill : adj.keySet()) {
			for (Skill e : adj.get(skill)) {
				list.add(e);
			}
		}
		return list;
	}

	public String toString() {
		String newLine = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		s.append("Vertices :" + V + ", Edges " + E() + newLine);
		for (Skill skill : adj.keySet()) {
			s.append("Node \n	" + skill + ": \n");
			s.append("	Adjacency List" + " :\n ");
			for (Skill e : adj.get(skill)) {
				s.append("		" + e.toString() + "\n");
			}
			s.append(newLine);
		}
		return s.toString();
	}
}
