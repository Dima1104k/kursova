package com.example33.demo8.dao;
import com.example33.demo8.model.Group;

import java.util.List;
public interface GroupDAO {

        void addGroup(Group code) throws Exception;

        void removeGroup(String groupCode) throws Exception;

        void updateGroup(String oldCode, String newCode, String newSchedule) throws Exception;

        List<Group> getAllGroups();
        Group getGroupByCode(String code) throws Exception;
        boolean groupExists(String groupName) throws Exception;

}