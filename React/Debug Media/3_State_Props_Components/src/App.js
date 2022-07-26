import React from "react";
import { Component } from "react";
import "./App.css";
import Todo from "./component/Todo";

class App extends Component {
  state ={
    name:"techworldthink",
    followers:74
  };

  increaseFollowers = () =>{
    this.setState({
      followers : this.state.followers + 1
    });
  };

  render() {
    return (
      <div className="App">
        <h1>hello {this.state.name}</h1>
        <button onClick={this.increaseFollowers}>follow</button>
        <Todo sendPropsData={this.state.followers} />
      </div>
    );
  }
}

export default App;
