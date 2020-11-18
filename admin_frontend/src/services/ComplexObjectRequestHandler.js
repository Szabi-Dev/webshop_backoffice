import React from 'react'

export const CompexObjectRequestHandler = () => {

    const getRequests = (newSet, oldSet, url, foreignIdName) =>{
        let toAdd =  newSet.filter(x => !oldSet.includes(x))
        let toRemove =  oldSet.filter(x => !newSet.includes(x))
        let requests = []
        toAdd.map ((dataToAdd) => {
            let req = createRequest(dataToAdd, "PATCH", url, foreignIdName)
            requests.push(req)
        })
        toRemove.map((dataToRemove) => {
            let req = createRequest(dataToRemove, "DELETE", url, foreignIdName)
            requests.push(req)
        })

        return requests

    }

    const createRequest = (data, method, url, foreignIdName) =>{
        return {
          "method" : method,
          "url" : url.replace(foreignIdName, data["id"]) 
        }
    }
  
   
    return {
        getRequests
    }

}