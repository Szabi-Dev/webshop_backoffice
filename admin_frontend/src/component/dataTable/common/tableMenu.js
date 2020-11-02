import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import EditModal from '../modal/editModal';

const tableMenuItems = [
    {field: "edit", name : "Edit"},
    {field: "delete", name: "Delete"}
  ]


export default function TableMenu(props){
    const [anchorEl, setAnchorEl] = React.useState(null);
    const [isOpen, setIsOpen] = React.useState(false);

    const closeModal = () => {
        setIsOpen(false)
    }

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    }

    const handleMenuItemClick = (item) => {
        setAnchorEl(null);
        if (item.field === "edit"){
            setIsOpen(true);
        }
    };

    return (
        <div>
        <IconButton aria-label="more" aria-haspopup="true" onClick={handleClick} >
            <MoreVertIcon />
        </IconButton>
        <Menu id="simple-menu" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose} >
            {tableMenuItems.map( (item) => (
                <MenuItem onClick={()=> handleMenuItemClick(item)}>{item.name}</MenuItem>
            ))}
        </Menu>
        <EditModal show={isOpen} handleModalClose={closeModal} />
        </div>
        
    )
}