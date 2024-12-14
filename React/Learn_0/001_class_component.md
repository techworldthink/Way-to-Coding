## Class component
A class component in React is one of the ways to define a component. It is based on ES6 JavaScript classes and provides additional features like state management and lifecycle methods. While functional components have become more popular with the introduction of hooks, class components are still an integral part of React, especially in older codebases.
```js
// App.js
import { Component } from "react";
import "./App.css";

class App extends Component {
  render() {
    return (
    <div className="App">
      <h1>hai</h1>
    </div>
    );
  }
}

export default App;
```

### Key Characteristics of Class Components

1. **Defined Using ES6 Classes:**  
   Class components are built by extending the `React.Component` base class, allowing them to inherit React features.

2. **`render()` Method:**  
   Every class component must include a `render()` method, which is responsible for returning the JSX that describes the UI.

3. **State Management:**  
   Class components have their own state, managed through `this.state`. The state can be updated dynamically using the `this.setState()` method.

4. **Lifecycle Methods:**  
   Class components provide access to various lifecycle methods like:
   - **`componentDidMount`**: Executes after the component is inserted into the DOM.
   - **`componentDidUpdate`**: Executes after the component updates due to changes in props or state.
   - **`componentWillUnmount`**: Executes just before the component is removed from the DOM.
   
   These methods help in managing side effects such as data fetching, subscriptions, or cleanup tasks.