import SwiftUI
import shared

struct ContentView: View {
    @EnvironmentObject var sampleViewModel: SampleViewModel
    let greet = Greeting().greet()

	var body: some View {
        Text(greet)//(sampleViewModel.greet())
//            .environmentObject(sampleViewModel)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
