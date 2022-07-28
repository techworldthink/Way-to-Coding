import React, { Component } from "react";

class List extends Component {
  state = {
    data: [
      {
        id: 1,
        name: "abc",
        age: 12,
      },
      {
        id: 2,
        name: "def",
        age: 14,
      },
    ],
  };

  render() {
    return (
      <div>
        <h1>List</h1>
        {/* {this.state.data.map((value, index) => {
          return <li>{value.id} - {value.name} - {value.age}</li>;
        })} */}
        {this.state.data.map((value, index) => (
          <li key={value.id}>
            {value.id} - {value.name} - {value.age}
          </li>
        ))}
      </div>
    );
  }
}

export default List;
