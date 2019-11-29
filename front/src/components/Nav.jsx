import React          from 'react';
import { withRouter } from 'react-router';
import                '../css/navStyles.css';
import {getClients} from "../Api";

class Nav extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            text: '',
            clients: [],
        }
    
        this.changeSearch = this.changeSearch.bind(this);
    }

    changeSearch(event){
        this.setState( {search: event.target.value} )
    }
    getAllClients(){
        getClients(this.state.search)
                    .then(result => { this.setState({clients: result})})
                    .catch(() => this.setState({ messageClient: 'Fallo la busqueda' })); 
    }


    //que ell texto que se muestra sea dinamico dependiendo de la pagina en la que se encuentra

    render() {
        return (
            <div className="containerNav">
              <div>
                <p className="titleNav">ADMINISTRACIÓN DE REGISTROS</p>
                    <br/> 
                
                 <div className="rowfilds">
                <input type="text" name="search" className="fieldForm "  value={this.state.search} onChange={this.changeSearch} placeholder="Buscar"/>                     
                <button type="button" className="searchForm" onClick={() => this.getAllClients()}>BUSCAR</button>
             </div>
            </div> 
            </div>
        );
    }
}

export default withRouter(Nav);