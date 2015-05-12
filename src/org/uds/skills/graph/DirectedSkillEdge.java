package org.uds.skills.graph;


public class DirectedSkillEdge {

	private final Skill parentSkillNode;
	private final Skill childSkillNode;

	public DirectedSkillEdge(Skill parentSkillNode, Skill childSkillNode) {
		super();
		this.parentSkillNode = parentSkillNode;
		this.childSkillNode = childSkillNode;
	}

	public Skill getChildSkillNode() {
		return childSkillNode;
	}

	public Skill getParentSkillNode() {
		return parentSkillNode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childSkillNode == null) ? 0 : childSkillNode.hashCode());
		result = prime * result + ((parentSkillNode == null) ? 0 : parentSkillNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectedSkillEdge other = (DirectedSkillEdge) obj;
		if (childSkillNode == null) {
			if (other.childSkillNode != null)
				return false;
		} else if (!childSkillNode.equals(other.childSkillNode))
			return false;
		if (parentSkillNode == null) {
			if (other.parentSkillNode != null)
				return false;
		} else if (!parentSkillNode.equals(other.parentSkillNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DirectedSkillEdge [parentSkillNode=" + parentSkillNode + ", childSkillNode=" + childSkillNode + "]";
	}
}
