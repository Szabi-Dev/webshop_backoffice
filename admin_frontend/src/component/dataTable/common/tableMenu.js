import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MoreVertIcon from '@material-ui/icons/MoreVert';
import EditModal from '../modal/editModal';
import DeleteMenuItem from './deleteMenuItem';

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

    return (
        <div>
        <IconButton aria-label="more" aria-haspopup="true" onClick={handleClick} >
            <MoreVertIcon />
        </IconButton>
        <Menu id="simple-menu" anchorEl={anchorEl} keepMounted open={Boolean(anchorEl)} onClose={handleClose} >
            <DeleteMenuItem actionLink={props.deleteLink} handleClose={handleClose} actionLink={props.selfLink} handleResponse={props.handleResponse}/>
        </Menu>
        <EditModal show={isOpen} handleModalClose={closeModal} />
        </div>
        
    )
}