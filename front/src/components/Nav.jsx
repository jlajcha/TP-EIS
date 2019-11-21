import React          from 'react';
import { withRouter } from 'react-router';
import                '../css/navStyles.css';


class Nav extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            text: '',
        }
    }


    //que ell texto que se muestra sea dinamico dependiendo de la pagina en la que se encuentra

    render() {
        return (
            <div className="containerNav">
                <p className="titleNav">ADMINISTRACIÓN DE REGISTROS</p>
            </div>
        );
    }
}

export default withRouter(Nav);