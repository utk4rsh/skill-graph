package org.uds.skills.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthSearchSkillGraph {

	private Map<Skill, Boolean> marked; // marked[v] = is there an s-v path
	private Queue<Skill> relatedSkills;

	public BreadthSearchSkillGraph() {
		marked = new HashMap<Skill, Boolean>();
		relatedSkills = new LinkedList<Skill>();
	}

	public Queue<Skill> performBFSAndChangeBoost(SkillGraph G, Skill source) {
		Queue<Skill> q = new LinkedList<Skill>();
		marked.put(source, true);
		q.add(source);
		relatedSkills.add(source);
		float boost = 1;
		while (!q.isEmpty()) {
			Skill v = q.remove();
			boost = v.getBoost() / 2;
			for (Skill w : G.adj(v)) {
				if (marked.get(w) == null || !marked.get(w)) {
					marked.put(w, true);
					q.add(w);
					w.setBoost(boost);
					relatedSkills.add(w);
				}
			}
		}
		return relatedSkills;
	}

	public Queue<Skill> performBFS(SkillGraph G, Skill source) {
		Queue<Skill> q = new LinkedList<Skill>();
		marked.put(source, true);
		q.add(source);
		relatedSkills.add(source);
		while (!q.isEmpty()) {
			Skill v = q.remove();
			for (Skill w : G.adj(v)) {
				if (marked.get(w) == null || !marked.get(w)) {
					marked.put(w, true);
					q.add(w);
					relatedSkills.add(w);
				}
			}
		}
		return relatedSkills;
	}

	public boolean hasPathTo(Skill v) {
		return marked.get(v.getVertexId());
	}

}
