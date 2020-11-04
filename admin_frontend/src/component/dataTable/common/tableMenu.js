import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import EditModal from '../modal/editModal';
import DeleteMenuItem from './deleteMenuItem';
import EditMenuItem from './editMenuItem';

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
    }

    return (
        <div>
        <IconButton aria-label="more" aria-haspopup="true" onClick={handleClick} >
            <MoreVertIcon />
        </IconButton>
        <Menu id="simple-menu" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose} >
            <DeleteMenuItem handleClose={handleClose} actionLink={props.currentItem["_links"]["self"]} handleResponse={props.handleResponse}/>
            <EditMenuItem currentItem={props.currentItem} actionLink={props.currentItem["_links"]["self"]} editTabs={props.editTabs} handleClose={handleClose} handleResponse={props.handleResponse}/>
        </Menu>
        </div>
        
    )
}