import React from 'react';

import TextField from '@material-ui/core/TextField';

const RoleEditGeneralTab = (props) =>{

    return (
    <form>
       <TextField id="standard-basic" name="name" defaultValue={props.currentItem.name} label="Name" onChange={props.handleAddChange} />
    </form>
    )
}

export {RoleEditGeneralTab}