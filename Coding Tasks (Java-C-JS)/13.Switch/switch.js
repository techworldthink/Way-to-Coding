function month(no) {
  var a = [
    "ab",
    "cd",
    "ef",
    "gh",
    "ij",
    "lm",
    "op",
    "qr",
    "st",
    "uv",
    "wx",
    "yz",
  ];
  switch (no) {
    case 1:
      console.log(a[0]);
      break;
    case 2:
      console.log(a[1]);
      break;
    case 3:
      console.log(a[2]);
      break;
    case 4:
      console.log(a[3]);
      break;
    case 5:
      console.log(a[4]);
      break;
    case 6:
      console.log(a[5]);
      break;
    case 7:
      console.log(a[6]);
      break;
    case 8:
      console.log(a[7]);
      break;
    case 9:
      console.log(a[8]);
      break;
    case 10:
      console.log(a[9]);
      break;
    case 11:
      console.log(a[10]);
      break;
    case 12:
      console.log(a[11]);
      break;
    default:
      console.log("invalid input");
  }
}
month(1);
