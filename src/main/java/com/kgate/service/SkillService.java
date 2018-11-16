package com.kgate.service;

import com.kgate.model.Skill;
import java.util.List;

public interface SkillService {

    public void addSkill(Skill skill);

    public List<Skill> getAllSkills();

    public void deleteSkill(Integer skill_id);

    public Skill getSkill(int skill_id);
    
    public Skill getSkillByName(String skillName);

    public Skill updateSkill(Skill skill);
}
