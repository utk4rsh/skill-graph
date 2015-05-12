package org.uds.skills.graph;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class Skill {

	public static final String ROOT_SKILL = "0";
	private final String vertexId;
	private final String skillText;
	private Set<String> similarSkills;
	private float boost = 1;

	public Skill(String skillText) {
		super();
		this.vertexId = md5(skillText);
		this.skillText = skillText;
		this.similarSkills = new HashSet<String>();
		addSimilarSkills(skillText);
	}

	public Skill(String vertexId, String skillText) {
		super();
		this.vertexId = vertexId;
		this.skillText = skillText;
		this.similarSkills = new HashSet<String>();
		addSimilarSkills(skillText);
	}

	public void addSimilarSkills(String skillSynonym) {
		similarSkills.add(skillSynonym);
	}

	public boolean isRoot() {
		if (ROOT_SKILL.equals(vertexId))
			return true;
		return false;
	}

	private String md5(String s) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(s.getBytes(), 0, s.length());
			BigInteger i = new BigInteger(1, m.digest());
			return String.format("%1$032x", i);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("MD5 Algorithm Error");
		}
		return "NO_MD5";
	}

	public Set<String> getSimilarSkills() {
		return similarSkills;
	}

	public void setSimilarSkills(Set<String> similarSkills) {
		this.similarSkills = similarSkills;
	}

	public float getBoost() {
		return boost;
	}

	public void setBoost(float boost) {
		this.boost = boost;
	}

	public static String getRootSkill() {
		return ROOT_SKILL;
	}

	public String getVertexId() {
		return vertexId;
	}

	public String getSkillText() {
		return skillText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((similarSkills == null) ? 0 : similarSkills.hashCode());
		result = prime * result
				+ ((skillText == null) ? 0 : skillText.hashCode());
		result = prime * result
				+ ((vertexId == null) ? 0 : vertexId.hashCode());
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
		Skill other = (Skill) obj;
		if (similarSkills == null) {
			if (other.similarSkills != null)
				return false;
		} else if (!similarSkills.equals(other.similarSkills))
			return false;
		if (skillText == null) {
			if (other.skillText != null)
				return false;
		} else if (!skillText.equals(other.skillText))
			return false;
		if (vertexId == null) {
			if (other.vertexId != null)
				return false;
		} else if (!vertexId.equals(other.vertexId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skill [vertexId=" + vertexId + ", skillText=" + skillText
				+ ", similarSkills=" + similarSkills + ", boost=" + boost + "]";
	}

}
