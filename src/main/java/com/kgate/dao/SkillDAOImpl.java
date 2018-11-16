package com.kgate.dao;

import com.kgate.model.Skill;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDAOImpl implements SkillDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSkill(Skill skill) {
        sessionFactory.getCurrentSession().saveOrUpdate(skill);
    }

    @SuppressWarnings("unchecked")
    public List<Skill> getAllSkill() {
        return sessionFactory.getCurrentSession().createQuery("from Skill")
                .list();
    }

    @Override
    public void deleteSkill(Integer skill_Id) {
        Skill skill = (Skill) sessionFactory.getCurrentSession().load(
                Skill.class, skill_Id);
        if (null != skill) {
            this.sessionFactory.getCurrentSession().delete(skill);
        }

    }

    @Override
    public Skill updateSkill(Skill skill) {
        sessionFactory.getCurrentSession().update(skill);
        return skill;
    }

    @Override
    public Skill getSkill(int skill_Id) {
        return (Skill) sessionFactory.getCurrentSession().get(
                Skill.class, skill_Id);
    }

    @Override
    public Skill getSkillByName(String skillName) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String hql = "from Skill skill where skill.skill_name=:skill_name";
    Query query =  sessionFactory.getCurrentSession().createQuery(hql);
    query.setParameter("skill_name", skillName);
      List<Skill> skills= query.list();
      if(skills != null && skills.size() > 0){
          return skills.get(0);
      }
      else{
          return null;
      }
    }

}
