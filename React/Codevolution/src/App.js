import './App.css';


import MyExport from './component/ExportSample';
import ClassMyExport from './classComponent/Exportclass';
import PropsSmple from './component/PropsSmple';
import StateExmpl from './classComponent/StateExmpl';
import CountState from './classComponent/CountState';
import EventHandler from './classComponent/EventHandler';
import Count from './component/CountState';
import EventHandlerFunction from './component/EventHandler';
import Parent from './classComponent/Parent';
import ParentFun from './component/Parent';
import ConditionalIfElse, { ConditionalShortCircuit, ConditionalTernary } from './classComponent/Conditional';
import Conditional from './component/Conditional';
import ListMap from './component/ListMap';
import StylesSheet from './component/StylesSheet';
import FormHandler from './component/FormHandler';

function App() {
  return (
    <div className="App">
      <MyExport />
      <ClassMyExport />
      <PropsSmple name=" Welcome Jaseem" classRoom = "MCA" pg="Master Degree" />
      <PropsSmple name=" Welcome Adil"  classRoom = "CS" />
      <PropsSmple name=" Welcome Ameer" classRoom = "BCA"/>
      <StateExmpl name="Jaseem" /> {/* its a class component using state */}
      <CountState /> {/* its a class component using state counting by clicking button*/}
      <Count /> {/* its a function component using state counting by clicking button*/}
      <EventHandler name="Ajk"/> {/* its a class component using state changing by clicking button*/}
      <EventHandlerFunction name="Function"/> {/* its a function component using state changing by clicking button*/}
      <Parent/> 
      <ParentFun/>
      <ConditionalIfElse/>
      <ConditionalTernary/>
      <ConditionalShortCircuit/>
      <Conditional/>
      <ConditionalIfElse/>
      <ListMap/>
      <StylesSheet  name = {true}/>

      <FormHandler/>
    </div>
  );
}

export default App;
