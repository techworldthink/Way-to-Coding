import React, { Component } from "react";

class Counter extends Component {
  state = {
    count: 0,
  };

  increaseCount = () => {
    this.setState({
      count: this.state.count + 1,
    });
  };

  decreaseCount = () => {
    this.setState({
      count: this.state.count - 1,
    });
  };

  render() {
    return (
      <div>
        <h2>Counter</h2>
        <h1>{this.state.count}</h1>
        <button onClick={this.increaseCount}>+</button>
        <button onClick={this.decreaseCount}>-</button>
      </div>
    );
  }
}

export default Counter;
