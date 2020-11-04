import React from 'react';

import TextField from '@material-ui/core/TextField';

const UserEditGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="firstName" value={props.currentItem.firstName} label="First Name" onChange={props.handleEditChange} />
       <TextField id="standard-basic" name="lastName" value={props.currentItem.lastName} label="Last Name" onChange={props.handleEditChange} />
       <TextField id="standard-basic" name="email" value={props.currentItem.email} label="E-mail" onChange={props.handleEditChange} />
    </form>
    )
}

export {UserEditGeneralTab}


