import React from 'react';

const SearchBar = (props) => {
    return (
      <input type = "text" value={props.keyword} placeholder={"Search"} />
    );
  }

  export default SearchBar