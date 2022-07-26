import React from "react";
import { Component } from "react";
import "./App.css";

class App extends Component {
  state ={
    name:"techworldthink",
  };

  render() {
    return (
      <div className="App">
        <h1>hello {this.state.name}</h1>
      </div>
    );
  }
}

export default App;
