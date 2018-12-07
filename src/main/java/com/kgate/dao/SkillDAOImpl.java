package com.kgate.dao;

import com.kgate.model.Skill;
import java.util.ArrayList;
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
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("skill_name", skillName);
        List<Skill> skills = query.list();
        if (skills != null && skills.size() > 0) {
            return skills.get(0);
        } else {
            return null;
        }
    }

    // return employeeSkill list
    @Override
    @SuppressWarnings("unchecked")
    public List<String> getEmployeeSkill(int empid) {
//        String query = "select skill2_.skill_name  from employee123 employee0_ cross join join_employee_skill listskill1_, Skills skill2_ where employee0_.id=listskill1_.id  and listskill1_.skill_Id=skill2_.skill_Id  and employee0_.id LIKE '" + empid + "'";
        String query = "select distinct(s.skill_name) from Skills s cross join join_employee_skill je,employee123 e1   where s.skill_id=je.skill_id and je.id= '" + empid + "'";
//        List<Skill> sList = new ArrayList<Skill>();
//        sList =  
//        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
//        System.out.println("List:  "+sList);
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
    }

	@Override
	 @SuppressWarnings("unchecked")
	public List<String> getEmployeeSkillByEmail(String email) {
		   String query ="select distinct(s.skill_name) from Skills s cross join join_employee_skill je,employee123 e1 where s.skill_id=je.skill_id and e1.email='"+email+"'";
		   return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}
}
