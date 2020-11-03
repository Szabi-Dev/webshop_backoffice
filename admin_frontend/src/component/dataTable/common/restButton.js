import React from 'react';
import Button from '@material-ui/core/Button';
import { RestCaller } from '../../../services/util/restCaller';

export default function RestButton(props){

    const handleOnClick = () => {
        RestCaller().makeRequest(props.actionLink['href'], props.action, props.payLoad)
            .then(data => console.log(data))
    }


    return (
        <Button variant="contained" onClick={handleOnClick}>{props.name}</Button>  
    )

}