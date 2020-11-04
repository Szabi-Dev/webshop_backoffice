import React from 'react';

import TextField from '@material-ui/core/TextField';

const PrivilegeEditGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="name" defaultValue={props.currentItem.name} label="Name" onChange={props.handleEditChange} />
    </form>
    )
}

export {PrivilegeEditGeneralTab}