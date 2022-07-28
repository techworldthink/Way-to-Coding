import React, { Component } from "react";

// Uncontrolled method
class Forms extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: "",
      lastName: "",
    };

    this.inputOne = React.createRef();
    this.inputTwo = React.createRef();
  }

  onSubmit = (event) => {
    console.log(this.inputOne.value);
    console.log(this.inputTwo.value);
  };

  // state = {
  //   firstName: "",
  //   lastName: "",
  // };

  // onSubmit = (event) => {
  //   console.log(this.state.firstName);
  //   console.log(this.state.lastName);
  // };

  render() {
    return (
      <div>
        <h1>Forms Component</h1>
        <form>
          <label>Firstname</label>
          <input
            type="text"
            name="firstName"
            ref={(input) => (this.inputOne = input)}
          />
          <label>Lastname</label>
          <input
            type="text"
            name="lastName"
            ref={(input) => (this.inputTwo = input)}
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
