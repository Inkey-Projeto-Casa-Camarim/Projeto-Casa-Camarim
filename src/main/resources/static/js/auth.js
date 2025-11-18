class AuthService {
    static BASE_URL = 'http://localhost:8080/api/auth';

    static async cadastrar(nome, telefone, senha) {
        console.log(JSON.stringify({ nome, telefone, senha }));

        const response = await fetch(`${this.BASE_URL}/cadastro`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ nome, telefone, senha })
        });
        
        if (!response.ok) {
            const error = await response.text();
            throw new Error(error);
        }
        
        return await response.json();
    }
    
    static async login(telefone, senha) {
        const response = await fetch(`${this.BASE_URL}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ telefone, senha })
        });
        
        if (!response.ok) {
            const error = await response.text();
            throw new Error(error);
        }
        
        const usuario = await response.json();
        localStorage.setItem('usuario', JSON.stringify(usuario));
        return usuario;
    }
    
    static logout() {
        localStorage.removeItem('usuario');
        localStorage.removeItem('servicoSelecionado');
        window.location.href = 'index.html';
    }
    
    static getUsuarioLogado() {
        const usuario = localStorage.getItem('usuario');
        return usuario ? JSON.parse(usuario) : null;
    }
    
    static isLoggedIn() {
        return this.getUsuarioLogado() !== null;
    }
    
    static requireAuth() {
        if (!this.isLoggedIn()) {
            window.location.href = 'userLogin.html';
            return false;
        }
        return true;
    }
}