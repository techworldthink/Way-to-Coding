## Events

```js
// Counter.js
import React, { Component } from "react";

export default class Todo extends Component {
  state = {
    counter: 0,
  };

  // increment (){
  // }

  increment = () => {
    this.setState({
      counter: this.state.counter + 1,
    });
  };

  render() {
    return (
      <div>
        <h1>{this.state.counter}</h1>
        <button onClick={this.increment}>+</button>
      </div>
    );
  }
}


```

```js
// Forms.js
import React, { Component } from "react";

export default class Forms extends Component {
  state = {
    fname: "",
    lname: "",
  };

  onHandleChange = (event) => {
    this.setState({
      //name : event.target.value
      [event.target.name]: event.target.value,
    });
  };

  onHandleSubmit = () => {
    console.log(this.state.fname);
    console.log(this.state.lname);
  };

  render() {
    return (
      <div>
        <input type="text" name="fname" onChange={this.onHandleChange} />
        <input type="text" name="lname" onChange={this.onHandleChange} />
        <button type="button" onClick={this.onHandleSubmit}>
          Submit
        </button>
      </div>
    );
  }
}


```