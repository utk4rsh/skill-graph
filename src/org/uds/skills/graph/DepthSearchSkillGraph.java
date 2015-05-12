package org.uds.skills.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DepthSearchSkillGraph {

	private Map<Skill, Boolean> marked;
	private int count;
	private Stack<Skill> skillStackFromDFS;

	public DepthSearchSkillGraph() {
		marked = new HashMap<Skill, Boolean>();
		skillStackFromDFS = new Stack<Skill>();
	}

	public Stack<Skill> performDFS(SkillGraph G, Skill s) {
		System.out.println("==Starting DFS from Node " + s + "==");
		System.out.println("Adjcency List is  -> ");
		System.out.println(G.adj(s));
		dfs(G, s);
		System.out.println("==Finished DFS==");
		System.out.println("==Total Node : " + count + " ==");
		return skillStackFromDFS;
	}

	private void dfs(SkillGraph G, Skill v) {
		count++;
		marked.put(v, true);
		for (Skill w : G.adj(v)) {
			if (marked.get(w) == null || !marked.get(w)) {
				w.setBoost(count);
				skillStackFromDFS.push(w);
				dfs(G, w);
			}
		}
	}

}
