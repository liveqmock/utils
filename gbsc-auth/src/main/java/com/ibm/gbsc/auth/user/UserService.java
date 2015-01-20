package com.ibm.gbsc.auth.user;

import java.util.List;
import java.util.Set;

import com.ibm.banking.framework.dto.PagedQueryResult;

/**
 * 
 * 用户及组织机构，角色功能接口.
 * 
 * @author Johnny
 * 
 */
public interface UserService {
	/**
	 * 主键取role.
	 * 
	 * @param auth
	 *            auth
	 * @return role
	 */
	Role getRole(String auth);

	/**
	 * @return all roles in the system
	 */
	List<Role> getAllRoles();

	/**
	 * @return all roles in this application
	 * @param appId
	 *            app
	 */
	List<Role> getAppRoles(Integer appId);

	/**
	 * @param id
	 *            id
	 * @return user
	 */
	User getUser(String id);

	/**
	 * @param param
	 *            param
	 * @return user with paging.
	 */
	PagedQueryResult<User> searchUser(UserPagedQueryParam param);

	/**
	 * 保存用户，同时保存用户所属的角色列表(主要用途).
	 * 
	 * @param user
	 *            user
	 */
	void updateUser(User user);

	/**
	 * @param userCode
	 *            the user code
	 * @param newPasswd
	 *            new password
	 * @param oldPassword
	 *            old password
	 */
	void updateUserPassword(String userCode, String newPasswd, String oldPassword);

	/**
	 * 按层级查找机构.
	 * 
	 * @param level
	 *            层级
	 * @param type
	 *            机构类型
	 * @return 指定的层级机构列表，不包括下级机构
	 */
	List<Organization> getOrganizationByLevelType(int level, String type);

	/**
	 * 按层级查找机构，同时取得所有的下级机构树.
	 * 
	 * @param level
	 *            level
	 * @return 机构树，及角色
	 */
	List<Organization> getOrgTreeByLevel(int level);

	/**
	 * 保存组织结构信息，同时保存该组织拥有的角色.
	 * 
	 * @param orgList
	 *            orgList to be saved.
	 */
	void saveOrgTree(List<Organization> orgList);

	/**
	 * 根据组织结构的code查询该组织下的人员.
	 * 
	 * @param orgCode
	 *            orgCode
	 * @return user under the org.
	 */
	List<User> getUserByOrgCode(String orgCode);

	/**
	 * 根据组织结构的code查询该组织下具有某种角色的人员.
	 * 
	 * @param orgCodes
	 *            org codes
	 * @param roleId
	 *            roles
	 * @return users
	 */
	List<User> getUserByOrgCodeAndRoleId(String[] orgCodes, String roleId);

	/**
	 * 根据组织结构的code查询该组织.
	 * 
	 * @param orgCode
	 *            org code
	 * @return org.
	 */
	Organization getOrganization(String orgCode);

	/**
	 * @param orgCode
	 *            orgCode
	 * @return org
	 */
	Organization getOrganizationLite(String orgCode);

	/**
	 * 更新组织结构信息.
	 * 
	 * @param org
	 *            org
	 */
	void updateOrganization(Organization org);

	/**
	 * 根据组织结构的code删除该组织.
	 * 
	 * @param orgCode
	 *            org code
	 */
	void delOrganization(String orgCode);

	/**
	 * 更加页面输入条件，分页查询角色信息.
	 * 
	 * @param queryParam
	 *            queryParam
	 * @return roles.
	 */
	PagedQueryResult<Role> searchRole(RolePagedQueryParam queryParam);

	/**
	 * 更新角色信息.
	 * 
	 * @param theRole
	 *            role
	 */
	void updateRole(Role theRole);

	/**
	 * 根据主键删除角色.
	 * 
	 * @param roleCode
	 *            role code
	 */
	void delRole(String roleCode);

	/**
	 * 该角色是否和组织机构有关系.
	 * 
	 * @param roleId
	 *            role id
	 * @return boolean.
	 */
	boolean haveRelationWithOrg(String roleId);

	/**
	 * 该角色是否和用户有关联.
	 * 
	 * @param roleId
	 *            role id
	 * @return boolean
	 */
	boolean haveRelationWithUser(String roleId);

	/**
	 * @param loginUser
	 *            loginUser
	 * @param resourceType
	 *            resourceType
	 * @param operType
	 *            operType
	 * @return boolean
	 */
	Set<String> getResource(LoginUser loginUser, String resourceType, int operType);
}