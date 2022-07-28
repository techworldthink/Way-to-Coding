import React, { Component } from "react";

class List extends Component {

  // First trigger method (run before laoding content)
  // Loading API ... etc
  componentDidMount(){
    console.log("Running componentDidMount ...");
  }

// when routing done it trigger 
// clear some events that running
  componentWillUnmount(){
    console.log("Running componentWillUnmount ...");
  }

  
  render() {
    return (
      <div>
        <h1>Component LifeCycle example</h1>
      </div>
    );
  }
}

export default List;
