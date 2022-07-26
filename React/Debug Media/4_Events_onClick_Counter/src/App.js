import React from "react";
import { Component } from "react";
import "./App.css";
import Counter from "./component/Counter";

class App extends Component {

  render() {
    return (
      <div className="App">
        <Counter />
      </div>
    );
  }
}

export default App;
