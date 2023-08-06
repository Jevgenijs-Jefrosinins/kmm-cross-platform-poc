import SwiftUI

@main
struct iOSApp: App {
    @StateObject var sampleViewModel = SampleViewModel()
    
    init() { }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
