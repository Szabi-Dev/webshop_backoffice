import React from 'react';
import { createStyles, Theme, makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';

import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { withRouter } from 'react-router-dom';

export const drawerWidth = 240

const useStyles = makeStyles({
    drawer: {
      width: drawerWidth
    }
  });

function PermanentDrawerLeft(props) {
    const classes = useStyles();
    
    const navigate = (menu) => {
        props.history.push(menu.link)
    }

    return (
   
      <Drawer className={classes.drawer} variant="permanent" anchor="left" >
        <List>
          {props.menu.map((menu) => (
            <ListItem button key={menu.displayName} onClick={() => navigate(menu)} >
              <ListItemText primary={menu.displayName} />
            </ListItem>
          ))}
        </List>
      </Drawer>
 
  );
}

export default withRouter(PermanentDrawerLeft);


