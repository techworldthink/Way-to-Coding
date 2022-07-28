import React from "react";
import { Component } from "react";
import "./App.css";
import About from "./component/About/About";
import Header from "./component/Header/Header";
import Todo from "./component/Todo/Todo";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

export default () => {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" exact element={<Todo />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </Router>
  );
};
