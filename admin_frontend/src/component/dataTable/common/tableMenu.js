import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import MoreVertIcon from '@material-ui/icons/MoreVert';

const tableMenuItems = [
    {field: "edit", name : "Edit"},
    {field: "delete", name: "Delete"}
  ]


export default function TableMenu(props){
    const [anchorEl, setAnchorEl] = React.useState(null);

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <div>
        <IconButton aria-label="more" aria-haspopup="true" onClick={handleClick} >
            <MoreVertIcon />
        </IconButton>
        <Menu id="simple-menu" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose} >
            {tableMenuItems.map( (item) => (
                <MenuItem onClick={handleClose}>{item.name}</MenuItem>
            ))}
        </Menu>
        </div>
        
    )
}