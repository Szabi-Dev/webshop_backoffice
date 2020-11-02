import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { withRouter } from 'react-router-dom';

const useStyles = makeStyles({
    drawer: {
      width: "190px"
    }
  });

const menu = [
    {id : "user", displayName : "User", link: "/user"},
    {id : "privileges", displayName : "Privileges", link: "/privileges"},
]


function PermanentDrawerLeft(props) {
    const classes = useStyles();
    
    const navigate = (menu) => {
        props.history.push(menu.link)
    }

    return (
      <Drawer className={classes.drawer} variant="permanent" anchor="left" >
        <List>
          {menu.map((menuItem) => (
            <ListItem button key={menuItem.displayName} onClick={() => navigate(menuItem)} >
              <ListItemText primary={menuItem.displayName} />
            </ListItem>
          ))}
        </List>
      </Drawer>
 
  );
}

export default withRouter(PermanentDrawerLeft);


