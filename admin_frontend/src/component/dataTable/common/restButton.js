import React from 'react';
import Button from '@material-ui/core/Button';
import { RestCaller } from '../../../services/util/restCaller';

export default function RestButton(props){

    const handleOnClick = async () => {
        console.log(props)
        RestCaller().makeRequest(props.actionLink['href'], props.action, props.payLoad)
            .then((data) => {
                if ( props.payLoad === undefined || props.payLoad === null || !props.payLoad.hasOwnProperty('requests')) {
                    props.handleResponse(data)
                    return
                }
                batchRequests(props.payLoad.requests, data["id"])
                props.handleResponse(data)
            })
    }

    const batchRequests = (requests, id) => {
        
        Object.keys(requests).map( requestGroup => {
            requests[requestGroup].map ( req => {
                req.url = req.url.replace("{id}", id)
                RestCaller().makeRequest(req.url, req.method )
            })
        })
    }


    return (
        <Button variant="contained" onClick={handleOnClick}>{props.name}</Button>  
    )

}