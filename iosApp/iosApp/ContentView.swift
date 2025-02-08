import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greet()
    
   
    let googleAuthenticator = GoogleAuthenticator()
    
    @State private var name = ""
    
    var body: some View {
        VStack{
            
            Text(name)
            Button {
                Task{
                    do{
                        guard let result = try await googleAuthenticator.login() else {
                            return
                        }
                        name = result
                    }catch{
                        name = "Something went wrong"
                    }
                

                }
            } label: {
                Text("Google sign in")
            }

        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
