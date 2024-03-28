## Class - state
```js
// App.js

import { Component } from "react";
import "./App.css";

class App extends Component {

  state = {
    data : "value",
    data1 : "value1"
  }

  render() {
    return (
    <div className="App">
      <h1>{this.state.data}</h1>
    </div>
    );
  }
}

export default App;
```