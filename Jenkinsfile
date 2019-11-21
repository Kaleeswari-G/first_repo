pipeline
{
   agent any
   environment{
      change = "${BUILD_URL}changes"
   }
   stages
   {
     stage('Hello')
     {
        steps
        {     
           echo "Hello"
           lastChanges since: 'LAST_SUCCESSFUL_BUILD', format:'SIDE',matching: 'LINE'
           sh "echo ${BUILD_URL}last-changes/"
           sh "echo ${BUILD_URL}changes/"
        }
     }
     stage("last-changes") {
         steps{
             checkout scm: [
    $class: 'GitSCM',
    branches: [[name: env.BRANCH_NAME]],
    extensions: [
        [
            $class: 'ChangelogToBranch',
            options: [
                compareRemote: 'origin',
                compareTarget: 'master'
            ]
        ]
    ]
    ]
]
           }
         }
      }
   }
   post{
       always{
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}last-changes/");
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}changes");
       }
   }
}
