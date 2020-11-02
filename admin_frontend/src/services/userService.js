import { RestCaller } from "./util/restCaller";


export const UserService = () => {
    const API_ENDPOINT = "/user";
    const restCaller = RestCaller()

    const fetchUsers = async () => {
        return restCaller.getRequest(API_ENDPOINT)
            .then((d) => {
                return d['_embedded']['userDataList']
            })
    }

    const getUser = async (id) => {
        return restCaller.getRequest(API_ENDPOINT + "/" + id)
    }

    return {
        fetchUsers,
        getUser
    }
}