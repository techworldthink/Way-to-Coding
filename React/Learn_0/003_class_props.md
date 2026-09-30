## **Props in React**

**Props** (short for "properties") in React are a mechanism for passing data from one component to another. They are used to make components reusable and dynamic by allowing them to receive data as input and render accordingly.

---

### **Key Features of Props:**

1. **Immutable:**  
   Props are read-only and cannot be modified by the receiving component. They are meant to be passed down as they are.
   
2. **Unidirectional Data Flow:**  
   Data flows from the parent component to the child component, adhering to React's one-way data binding principle.

3. **Dynamic:**  
   Props can be of any data type (e.g., string, number, array, object, function) and can be used to customize the behavior or appearance of components.

4. **Reusable Components:**  
   Props enable the creation of reusable components by passing different data to render different outputs.

---

### **How to Use Props**

1. **Passing Props from Parent to Child:**

   Props are passed from a parent component to a child component as attributes of the JSX element.

   ```jsx
   const ParentComponent = () => {
     return <ChildComponent name="John" age={25} />;
   };
   ```

2. **Accessing Props in Child Component:**

   In a functional component, props are passed as an argument.  
   In a class component, they are accessed using `this.props`.

   **Functional Component Example:**

   ```jsx
   const ChildComponent = (props) => {
     return (
       <div>
         <h1>Name: {props.name}</h1>
         <h2>Age: {props.age}</h2>
       </div>
     );
   };
   ```

   **Class Component Example:**

   ```jsx
   import React, { Component } from 'react';

   class ChildComponent extends Component {
     render() {
       return (
         <div>
           <h1>Name: {this.props.name}</h1>
           <h2>Age: {this.props.age}</h2>
         </div>
       );
     }
   }

   export default ChildComponent;
   ```

---

### **Default Props**

You can define default values for props in case they are not provided by the parent component:

```jsx
const ChildComponent = (props) => {
  return <h1>Hello, {props.name}!</h1>;
};

ChildComponent.defaultProps = {
  name: "Guest"
};
```

---

### **Prop Validation with `prop-types`**

React provides a library called `prop-types` to validate the props passed to a component. This helps catch bugs by ensuring that the correct data types are passed.

1. **Install `prop-types`:**
   ```bash
   npm install prop-types
   ```

2. **Usage Example:**
   ```jsx
   import PropTypes from 'prop-types';

   const ChildComponent = (props) => {
     return <h1>Name: {props.name}</h1>;
   };

   ChildComponent.propTypes = {
     name: PropTypes.string.isRequired
   };
   ```

---

### **Passing Functions as Props**

Props can also be functions, enabling parent components to pass behavior to child components.

```jsx
const ParentComponent = () => {
  const greet = (name) => alert(`Hello, ${name}!`);

  return <ChildComponent greet={greet} />;
};

const ChildComponent = (props) => {
  return <button onClick={() => props.greet("John")}>Greet</button>;
};
```

---

### **Example: Reusable Button Component**

```jsx
const Button = (props) => {
  return (
    <button style={{ backgroundColor: props.color }} onClick={props.onClick}>
      {props.label}
    </button>
  );
};

// Usage
const App = () => {
  const handleClick = () => alert("Button clicked!");

  return (
    <div>
      <Button color="blue" label="Click Me" onClick={handleClick} />
    </div>
  );
};
```

---

### **Props vs State**

| Feature          | Props                       | State                     |
|-------------------|-----------------------------|---------------------------|
| **Definition**    | Passed from parent to child | Managed within a component |
| **Mutability**    | Immutable                  | Mutable                   |
| **Usage**         | For passing data            | For managing component-specific data |
| **Access**        | `props` or `this.props`     | `state` or `this.state`   |

---

### **Conclusion**

Props are a powerful way to pass data and behavior to components in React, making them dynamic and reusable. They enable a parent-child communication structure while ensuring that components remain predictable and maintainable.



### Example : 

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