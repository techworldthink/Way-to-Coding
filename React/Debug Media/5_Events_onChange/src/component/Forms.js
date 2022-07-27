import React, { Component } from "react";

class Forms extends Component {
  state = {
    firstName: "",
    lastName: "",
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  onSubmit = (event) => {
    console.log(this.state.firstName);
    console.log(this.state.lastName);
  };

  render() {
    return (
      <div>
        <h1>Forms Component</h1>
        <form>
          <label>Firstname</label>
          <input
            type="text"
            name="firstName"
            value={this.state.firstName}
            onChange={this.handleChange}
          />
          <label>Lastname</label>
          <input
            type="text"
            name="lastName"
            value={this.state.lastName}
            onChange={this.handleChange}
          />
          <button type="button" onClick={this.onSubmit}>
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default Forms;
