library identifier: 'first_repo@test', retriever: modernSCM([
    $class: 'GitSCMSource',
    remote: 'https://github.com/Kaleeswari-G/first_repo.git',
    credentialsId: '77'
])

pipeline
{
   agent any
   environment{
      change = "${BUILD_URL}changes"
   }
   
   parameters {
        choice(name: 'BUILD_TYPE', choices: ['dev', 'release', 'prod'], description: 'Select the environment for Artifactory Push')
   }
   
   stages
   {
     stage('Hello')
     {
        steps
        {     
           echo "Hello"
           lastChanges since: 'PREVIOUS_REVISION', format:'SIDE',matching: 'LINE'
           sh "echo ${BUILD_URL}last-changes/"
           sh "echo ${BUILD_URL}changes/"
        }
     }
     stage("last-changes") {
         steps{
             git url: 'https://github.com/jenkinsci/last-changes-plugin.git'
             script{
              def publisher = LastChanges.getLastChangesPublisher "LAST_SUCCESSFUL_BUILD", "SIDE", "LINE", true, true, "", "", "", "", ""
              publisher.publishLastChanges()
              def changes = publisher.getLastChanges()
              //println(changes.getEscapedDiff())
              for (commit in changes.getCommits()) {
                  //println(commit)
                  def commitInfo = commit.getCommitInfo()
                  //println(commitInfo)
                  println(commitInfo.getCommitMessage())
                  //println(commit.getChanges())
              }
           }
         }
      }
   }
   post{
       always{
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}last-changes/");
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}changes");
           test()
       }
   }
}
