import React from 'react'

export const CompexObjectRequestHandler = () => {

    const getRequests = (newSet, oldSet, url, foreignIdName) =>{
        let requests = []
        
        let newsetIds = returnIds(newSet)
        let oldsetIds = returnIds(oldSet)
        let toAdd =  newsetIds.filter(x => !oldsetIds.includes(x))
        let toRemove =  oldsetIds.filter(x => !newsetIds.includes(x))
        
        toAdd.map ((idToAdd) => {
            let req = createRequest(idToAdd, "PATCH", url, foreignIdName)
            requests.push(req)
        })
        toRemove.map((idToRemove) => {
            let req = createRequest(idToRemove, "DELETE", url, foreignIdName)
            requests.push(req)
        })

        return requests

    }

    const createRequest = (id, method, url, foreignIdName) =>{
        return {
          "method" : method,
          "url" : url.replace(foreignIdName, id) 
        }
    }
  
    const returnIds = (set) => {
        let setIdList = []
        
        set.forEach(function (item, index) {
            setIdList.push(item["id"])
        });
        return setIdList;
    }
   
    return {
        getRequests
    }

}