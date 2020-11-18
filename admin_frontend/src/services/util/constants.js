export const BACKEND_BASE_URI = "http://localhost:8080"

export const USER_URI = BACKEND_BASE_URI + "/user"
export const ROLE_URI = BACKEND_BASE_URI + "/role"
export const PRIVILEGE_URI = BACKEND_BASE_URI + "/privilege"

export const USER_ROLE_URI = USER_URI + "/{id}/role/{roleId}"

export const ROLE_PRIVILEGE_URI = ROLE_URI + "/{id}/privilege/{privilegeId}"