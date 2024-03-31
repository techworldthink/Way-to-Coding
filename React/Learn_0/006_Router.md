## Router 

```bash
npm i react-router-dom
```

```js
// App.js 

import { Component } from "react";
import "./App.css";

import Header from "./component/Header";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Forms from "./component/Forms";
import Todo from "./component/Todo";
import home from "./component/home";

class App extends Component {
  render() {
    return (
      <Router>
        <Header />
        <Routes>
          <Route path="/" Component={home}></Route>
          <Route path="/todo" Component={Todo}></Route>
          <Route path="/forms" Component={Forms}></Route>
        </Routes>
      </Router>
    );
  }
}

export default App;

```

```js
// Header.js 

import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
  return (
    <div>
      <Link to="/">Home</Link>
      <Link to="/todo">Todo</Link>
      <Link to="/forms">Forms</Link>
    </div>
  )
}

```