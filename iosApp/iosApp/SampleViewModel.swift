//
//  SampleViewModel.swift
//  iosApp
//
//  Created by mykhailo.dontsov on 06/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import Combine
import shared

class SampleViewModel: NSObject, ObservableObject {
    private var greeting: Greeting
    
//    private var greetingSubscriptions = Set<AnyCancellable>()
    
    //All use cases are available through Container class - e.g. Container().getSignInUseCase()
    init(greeting: Greeting = Container().getGreeting()) {
        self.greeting = greeting
    }
    
    func greet() -> String {
        return self.greeting.greet()
    }
    
    //Sample code for async invocation of multiplatform API from Swift code
    // To use - replace "greet" and "greeting" with proper use case and result
    
//    func subscribeForGreetingsUpdates() {
//        if !self.greetingSubscriptions.isEmpty {
//            self.greetingSubscriptions.removeAll()
//        }
//
//        self.greetAsync()
//            .receive(on: DispatchQueue.main)
//            .sink(receiveCompletion: { [weak self] completion in
//                switch completion {
//                case .failure(let error):
//                    self?.errorReceived = error
//                case .finished:
//                    return
//                }
//            }, receiveValue: { [weak self] result in
//                //process result from use case
//            })
//            .store(in: &greetingSubscriptions)
//    }
    
//    func greetAsync() -> Future<String, Error> {
//        return Future() { promise in
//            greeting.execute(params: parameters) { domainResponse, error in
//                if domainResponse is DomainResponseContent {
//                    guard let domainResponseResult = (domainResponse as? DomainResponseContent)?.result else { return }
//                    promise(.success(domainResponseResult))
//                } else if domainResponse is DomainResponseError {
//                    if let message = (domainResponse as? DomainResponseError)?.message {
//                        promise(.failure(SampleError.domain(message)))
//                    } else {
//                        promise(.failure(SampleError.unknown))
//                    }
//                }
//            }
//        }
//    }
}
