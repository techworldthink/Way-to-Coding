## Class - props

```js
// App.js
import { Component } from "react";
import "./App.css";
import Todo from "./component/Todo"

class App extends Component {

  state = {
    user_name : "world"
  }

  render() {
    return (
    <div className="App">
      <h1>Hello </h1>
      <Todo user_name={this.state.user_name}/>
    </div>
    );
  }
}

export default App;
```

```js
// component/Todo.js

import React, { Component } from 'react'


export default class Todo extends Component {

  render() {
    return (
      <div>
        <h1>{this.props.user_name}</h1>
      </div>
    )
  }
}

```