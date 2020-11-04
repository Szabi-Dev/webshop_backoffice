import React from 'react';

import TextField from '@material-ui/core/TextField';

const UserAddGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="firstName" label="First Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" name="lastName" label="Last Name" onChange={props.handleAddChange} />
       <TextField id="standard-basic" name="email" label="E-mail" onChange={props.handleAddChange} />
       <TextField id="standard-password-input" name="password" label="Password" type="password" onChange={props.handleAddChange} />
    </form>
    )
}

export {UserAddGeneralTab}