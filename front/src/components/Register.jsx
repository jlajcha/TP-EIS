import React    from "react";
import {register} from "../Api";
import                  '../css/loginStyles.css';
import 'bootstrap/dist/css/bootstrap.min.css';

export default class Register  extends React.Component{

    constructor(props) {
        super(props);

        this.state = {
                firstName: '',
                lastName: '',
                dni:'',
                tel: '',
                adress: '',
                mail:''
                    };
        
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({[event.target.name]: event.target.value});
       
    }

    handleSubmit(event) {
        event.preventDefault();
        register(this.state)
        .then(user => this.props.history.push({ pathname: '/register' }))//TODO ver redireccionamiento
        .catch((error) => {
            console.log (error);
            this.setState({ error:"Complete Todos los CAMPOS"})//TODO ver si es necesario            
        });        
    }

    
    
    render(){
        
        return(
                <div className="containerForm">
                    <form onSubmit= {this.handleSubmit} className="formRegister">
                        <p className="titleForm">Registrar cliente</p>
                        <div className="rowfilds">
                            <input type="text" name="firstName" className="fieldForm "  value={this.state.firstName} onChange={this.handleChange} placeholder="Nombre"/>                     
                            <input type="text" name ="lastName" className = "fieldForm"  value={this.state.lastName} onChange={this.handleChange} placeholder="Apellido"/>          
                            </div>
                        <div className="rowfilds">
                            <input type="text" name ="dni"  className="fieldForm" value={this.state.dni} onChange={this.handleChange}placeholder="DNI"/> 
                            <input type="text" name ="tel" className="fieldForm" value={this.state.tel} onChange={this.handleChange} placeholder="Tel."/>
                            </div>
                        <div className="rowfilds">
                            <input type="text" name ="adress" className="fieldForm" value={this.state.adress} onChange={this.handleChange} placeholder="Domicilio"/>
                            <input type="text" name ="mail" className="fieldForm" value={this.state.mail} onChange={this.handleChange} placeholder="Mail"/>
                        </div>
                        {/* <p>{this.state.error}</p> */}
                        <p className="titleForm mascotas">Mascotas</p>
                        <div className="containerPet">
                            <p className="textForm">Sin mascotas</p>
                            <button className="addPet">Agregar</button>
                        </div>
                        <input className="submitRegister" type="submit" value ="Registrar" ></input>
                    </form>
                </div>
            
        );
    }
}
