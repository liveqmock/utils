package com.ibm.gbsc.auth.user;

import java.util.List;

import com.ibm.gbsc.auth.model.Organization;
import com.ibm.gbsc.auth.model.Role;
import com.ibm.gbsc.auth.model.User;
import com.ibm.gbsc.auth.vo.UserPagedQueryParam;
import com.ibm.gbsc.common.vo.PagedQueryResult;

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
	 * @param code
	 *            user code
	 * @return user
	 */
	User getUser(String code);

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
	 * 新增用户
	 *
	 * @param user
	 *            user
	 */
	void saveUser(User user);

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
	 * 根据组织结构的code查询该组织下的人员.
	 *
	 * @param orgCode
	 *            orgCode
	 * @return user under the org.
	 */
	List<User> getUserByOrgCode(String orgCode);

	/**
	 * 根据组织结构的code查询该组织.
	 *
	 *
	 * @param orgCode
	 *            机构代码
	 * @param loadRoles
	 *            是否要加载roles
	 * @param loadUsers
	 *            是否要加载users;
	 * @param loadChildren
	 *            是否要加载children;
	 * @return
	 */
	Organization getOrganization(String orgCode, boolean loadRoles, boolean loadUsers, boolean loadChildren);

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
	 * @param oldOrg
	 */
	void saveOrganzation(Organization org);

}
